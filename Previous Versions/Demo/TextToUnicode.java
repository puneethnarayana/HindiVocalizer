import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class TextToUnicode {

	static String[][] UnicodeStore = new String[56][2];
	BufferedReader br = null;
	static int ctr = 0;
	static int inputFileLength1 = 0;
	static int inputFileLength2 = 0;

	public static void main(String[] args) {

		// READ UNICODE MAPPING FROM FILE AND STORE IN ARRAY
		UnicodeStore = storeUnicode();

		// FIND LENGTH OF INPUT FILE
		inputFileLength1 = inputFileLength("input1.txt");
		System.out.println("Length of Input 1 = " + inputFileLength1);
		Character[] inputArray1 = new Character[inputFileLength1];

		// READ INPUT FILE AND STORE IN AN ARRAY
		storeInput(inputArray1, "input1.txt");

		// PRINT INPUT
		for (int i = 0; i < inputArray1.length; i++) {
			System.out.println(i+" "+inputArray1[i]);
		}

		// MAP and STORE IN A FILE
		String ans1[] = mapAndStore(inputArray1);

		// append the alphabets with vowels
		ArrayList<String> soundMap = new ArrayList<String>();
		soundMap = soundDB(ans1);

		// map the sound units with the corresponding wav file
		soundUnitMap(soundMap);
	}

	private static void soundUnitMap(ArrayList<String> soundMap) {
		
		System.out.println("\n");

		File sample1 = new File("DB//"+soundMap.get(0) + ".wav");
		if(!sample1.exists())
			sample1=new File("DB//notFound.wav");
		File sample2 = new File("DB//"+soundMap.get(1) + ".wav");
		if(!sample2.exists())
			sample2=new File("DB//notFound.wav");

		File fileOut = new File("DB//"+"combined.wav");
		try {
			AudioInputStream audio1 = AudioSystem.getAudioInputStream(sample1);
			AudioInputStream audio2;

			audio2 = AudioSystem.getAudioInputStream(sample2);

			AudioInputStream audioBuild = new AudioInputStream(
					new SequenceInputStream(audio1, audio2),
					audio1.getFormat(), audio1.getFrameLength()
							+ audio2.getFrameLength());

			for (int i = 2; i < soundMap.size(); i++) {
				sample2 = new File("DB//"+soundMap.get(i) + ".wav");
				if(!sample2.exists())
					sample2=new File("DB//notFound.wav");

				

				audioBuild = new AudioInputStream(new SequenceInputStream(
						audioBuild, /* keep creating new input streams */
						AudioSystem.getAudioInputStream(sample2)),
						audioBuild.getFormat(), audioBuild.getFrameLength()
								+ audio2.getFrameLength());

			}

			AudioSystem.write(audioBuild, AudioFileFormat.Type.WAVE, fileOut);
			AudioPlayer p = AudioPlayer.player;

			AudioStream as = new AudioStream(
					new FileInputStream("DB//"+"combined.wav"));
			p.start(as);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> soundDB(String[] inputArray1) {

		ArrayList<String> soundUnits = new ArrayList<String>();
		String unit;
		for (int i = 0; i < inputArray1.length; i++) {
			unit = inputArray1[i];

			if (i + 1 < inputArray1.length && isIntNumber(inputArray1[i + 1])) {
				unit = unit.concat(inputArray1[i + 1]);
				i++;
			}
			soundUnits.add(unit);
		}

		return soundUnits;
	}

	public static boolean isIntNumber(String num) {
		try {
			Integer.parseInt(num);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	static String[] mapAndStore(Character[] inputArray) {

		String mapping[] = new String[inputArray.length];
		// int mapctr = 0;
		ctr = 0;

		FileWriter fstream = null;
		try {
			fstream = new FileWriter("output.txt", false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fstream);

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < 56; j++) {
				if (inputArray[i].toString().compareTo(" ") == 0) {
					try {
						out.write("space");
						out.write(" ");
						mapping[ctr++] = "space";
						break;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (inputArray[i].toString().compareTo(UnicodeStore[j][0]) == 0) {
					try {
						out.write(UnicodeStore[j][1]);
						out.write(" ");
						mapping[ctr++] = UnicodeStore[j][1];
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return mapping;
	}

	static String[][] storeUnicode() {
		String[][] UnicodeStore = new String[56][2];
		BufferedReader br = null;
		int ctr = 0;

		try {

			String sCurrentLine;

			//br = new BufferedReader(new FileReader("Book1.txt"));
			String s = new java.util.Scanner( new java.io.File("Book1.txt"), "UTF-16" ).useDelimiter("\\A").next();

			//while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(s);
				int num=0;
				StringTokenizer st = new StringTokenizer(s, "\n ");
				while (st.hasMoreTokens()) {
					//System.out.println("Enter");
					String tok = st.nextToken().trim();
					//System.out.println(tok);
					UnicodeStore[ctr][num] = tok;
					num=1-num;
					if(num==0)
						ctr++;
					//System.out.println("ctr = "+ctr);
				}
			//}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return UnicodeStore;

	}

	static int inputFileLength(String string) {
		int inputFileLength = 0;
		BufferedReader br = null;
		try {

			String sCurrentLine;

			String s = new java.util.Scanner( new java.io.File(string), "UTF-16" ).useDelimiter("\\A").next();
			//br = new BufferedReader(new FileReader(string));

			//while ((sCurrentLine = br.readLine()) != null) {
				char[] array = s.toCharArray();
				inputFileLength += array.length;
			//}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return inputFileLength;
	}

	static void storeInput(Character[] inputArray, String string) {
		BufferedReader br = null;
		try {

			String s = new java.util.Scanner( new java.io.File(string), "UTF-16" ).useDelimiter("\\A").next();
			String sCurrentLine;
			ctr = 0;
			//br = new BufferedReader(new FileReader(string));

			//while ((sCurrentLine = br.readLine()) != null) {
				char[] array = s.toCharArray();
				for (int i = 0; i < array.length; i++) {
					inputArray[ctr] = array[i];
					ctr++;
				}
			//}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}