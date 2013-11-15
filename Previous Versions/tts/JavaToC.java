import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JavaToC {

	static int bookSize = 51;
	static String[][] UnicodeStore = new String[bookSize][2];
	BufferedReader br = null;
	static int ctr = 0;
	static int inputFileLength1 = 0;
	static int inputFileLength2 = 0;

	public static void main(String[] args) {

		UnicodeStore = storeUnicode();

		// FIND LENGTH OF INPUT FILE
		inputFileLength1 = inputFileLength("input3.txt");
		Character[] inputArray1 = new Character[inputFileLength1];

		// READ INPUT FILE AND STORE IN AN ARRAY
		storeInput(inputArray1, "input3.txt");

		// MAP and STORE IN A FILE
		String ans1[] = mapAndStore(inputArray1);

		storeOutputFiles(ans1);

		
		  try { Process proc = Runtime.getRuntime().exec("./make.sh");
		  BufferedReader read = new BufferedReader(new InputStreamReader(
		  proc.getInputStream())); try { proc.waitFor();
		  
		  } catch (InterruptedException e) {
		  System.out.println(e.getMessage()); } while (read.ready()) {
		  System.out.println(read.readLine()); } } catch (IOException e) {
		  System.out.println(e.getMessage()); }
		 

	}

	private static void storeOutputFiles(String[] ans1) {
		deleteExistingFiles();
		int count = 0;
		// System.out.println(ans1.length + "ans len");
		for (int i = 0; i < ans1.length; i++) {
			// System.out.println(ans1[i] + " ans" + i);
			if (!ans1[i].isEmpty()) {

				if (ans1[i].equalsIgnoreCase("fs"))
					count++;
			}
		}
	//	System.out.println(count + " count");
		int noOfSentences = (int) Math.ceil((double) count / 6.0);
		//System.out.println(noOfSentences + " No of sentences in a file");

		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			char j = 'a';
			int cnt = 0;
			String fileName = "";

			String[] sentences = new String[100];

			String sen = "";
			int start = 0;
			for (int i = 0; i < ans1.length; i++) {
				sen = sen + " " + ans1[i];
			}
			sentences = sen.split("fs");
			//System.out.println(sentences.length + " No of sentences");
			int i = 0, len = 0;

			for (int k = 0; k < sentences.length; k++) {
				if (i < sentences.length) {
					fileName = "output" + j + ".txt";
					fstream = new FileWriter(fileName, true);
					out = new BufferedWriter(fstream);

					while (cnt < noOfSentences && i < sentences.length) {
						System.out.println("Sentence no. " + i + " "
								+ sentences[i]);
						System.out.println("@ " + fileName);
						out.write(sentences[i]);
						// out.write("space");
						cnt++;
						i++;
					}
				}

				cnt = 0;
				j++;
				out.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

	private static void deleteExistingFiles() {
		char o = 'a';
		String fileName = "";
		for (int i = 0; i < 6; i++) {
			fileName = "output" + o + ".txt";
			File f = new File(fileName);
			if (f.exists())
				f.delete();
			o++;

		}
	}

	static String[] mapAndStore(Character[] inputArray) {

		String mapping[] = new String[inputArray.length];
		// System.out.println(inputArray.length + " len");
		// int mapctr = 0;
		ctr = 0;

		FileWriter fstream = null;
		try {
			fstream = new FileWriter("output.txt", false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fstream);
		int flag = 0;
		for (int i = 0; i < inputArray.length; i++) {
			// System.out.println(inputArray[i] + " input" + i);
			for (int j = 0; j < bookSize; j++) {

				if (inputArray[i].toString().compareTo(" ") == 0) {
					try {
						flag = 1;
						out.write("space");
						out.write(" ");
						mapping[ctr] = "space";
						// System.out.println(mapping[ctr] + " space" + ctr);
						ctr++;
						break;

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (inputArray[i].toString().compareTo(UnicodeStore[j][0]) == 0) {
					try {
						flag = 1;
						out.write(UnicodeStore[j][1].trim());
						out.write(" ");
						mapping[ctr] = UnicodeStore[j][1];
						// System.out.println(mapping[ctr] + " match" + ctr);
						ctr++;
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}

			// System.out.println(flag + " " + i);
			if (flag == 0) {
				try {
					out.write("notFound");
					out.write(" ");
					mapping[ctr] = "notFound";
					// System.out.println(mapping[ctr] + " not found" + ctr);
					ctr++;
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			flag = 0;
		}

		try {
			// System.out.println(mapping.length + " map len");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return mapping;
	}

	static String[][] storeUnicode() {
		String[][] UnicodeStore = new String[bookSize][2];
		BufferedReader br = null;
		int ctr = 0;

		try {

			String sCurrentLine;

			// br = new BufferedReader(new FileReader("Book1.txt"));
			String s = new java.util.Scanner(new java.io.File("Book1.txt"),
					"UTF-16").useDelimiter("\\A").next();

			// while ((sCurrentLine = br.readLine()) != null) {
			// System.out.println(s);
			int num = 0;
			StringTokenizer st = new StringTokenizer(s, "\n ");
			while (st.hasMoreTokens()) {
				// System.out.println("Enter");
				String tok = st.nextToken();

				UnicodeStore[ctr][num] = tok.trim();

				num = 1 - num;
				if (num == 0)
					ctr++;
				// System.out.println("ctr = "+ctr);
			}
			// }

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

			String s = new java.util.Scanner(new java.io.File(string), "UTF-16")
					.useDelimiter("\\A").next();
			// br = new BufferedReader(new FileReader(string));

			// while ((sCurrentLine = br.readLine()) != null) {
			char[] array = s.toCharArray();
			inputFileLength += array.length;
			// }

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

			String s = new java.util.Scanner(new java.io.File(string), "UTF-16")
					.useDelimiter("\\A").next();
			// String sCurrentLine;
			ctr = 0;
			// br = new BufferedReader(new FileReader(string));
			System.out.println(s);
			// while ((sCurrentLine = br.readLine()) != null) {
			char[] array = s.toCharArray();
			for (int i = 0; i < array.length; i++) {

				inputArray[ctr] = array[i];
				ctr++;
			}
			// }

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
