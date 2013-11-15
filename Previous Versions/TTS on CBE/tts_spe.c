#include<stdio.h>
#include<spu_mfcio.h>
#include<string.h>
#include<stdlib.h>
#include<malloc.h>
int main(unsigned long long speid) {
 // read SPU id using mailbox
  unsigned int spu_id = spu_read_in_mbox();
printf ("\n SPU %llx %d\n",speid,spu_id);
/*FILE *fp,*fp1;
fp =fopen("abcd","r");
fp1 =fopen("pqrs.sh","w");
char ch[5];
char str[10];
fscanf(fp,"%s",ch);
fprintf(fp1,"%s","sndfile-concat ");
while(!feof(fp)) {
	strcpy(str,ch);
	strcat(str,".wav ");
	printf("%s",str);
	fprintf(fp1,"%s",str);
	strcpy(str,"");
	fscanf(fp,"%s",ch);}
fprintf(fp1,"%s","output.wav");
fclose(fp);
fclose(fp1);
*/
if(spu_id == 0) {
char filename[10] = "output";
 
  
  FILE *fp;
  strcat(filename,"a");
  strcat(filename,".txt");
 

  
fp = fopen("outputa.txt","r");

  fseek(fp, 0L, SEEK_END);
  int sz = ftell(fp);
  fseek(fp, 0L, SEEK_SET);
 
  char *str = (char *)malloc(sz);
  fgets(str, sz, fp);

  int i;
  char newstr[strlen(str)];
  for(i=0; i<strlen(newstr); i++)
  {
     newstr[i]=" ";
  }
  for(i=0; i<strlen(str); i++)
  {
     newstr[i]=str[i];
     if(isdigit((int)str[i]))
     {
	newstr[i-1]=str[i];
	newstr[i]=' ';
     }
  }
  
  fclose(fp);
  char opname[10] = "spe";
  strcat(opname,"a");
  strcat(opname,".txt");
  fp=fopen(opname,"w");
  fputs(newstr, fp);
  fclose(fp);

char shname[10] = "DB/spe";
  strcat(shname,"a");
  strcat(shname,".sh");

FILE *fp2,*fp1;
fp2 =fopen(opname,"r");
fp1 =fopen(shname,"w");
char ch[5];
char str2[35];
fscanf(fp2,"%s",ch);
fprintf(fp1,"%s","sndfile-concat ");
while(!feof(fp2)) {
strcpy(str2,"/root/Desktop/tts/DB/");
	strcat(str2,ch);
	strcat(str2,".wav ");
	fprintf(fp1,"%s",str2);
	strcpy(str2,"");
	fscanf(fp2,"%s",ch);}
fprintf(fp1,"%s","outputa.wav;");
fclose(fp2);
fclose(fp1);

}
else if (spu_id == 1) {
char filename[10] = "output";
 
  FILE *fp;
  strcat(filename,"b");
  strcat(filename,".txt");
    
fp = fopen("outputb.txt","r");

  fseek(fp, 0L, SEEK_END);
  int sz = ftell(fp);
  fseek(fp, 0L, SEEK_SET);
 
  char *str = (char *)malloc(sz);
  fgets(str, sz, fp);


  int i;
  char newstr[strlen(str)];
  for(i=0; i<strlen(newstr); i++)
  {
     newstr[i]=" ";
  }
  for(i=0; i<strlen(str); i++)
  {
     newstr[i]=str[i];
     if(isdigit((int)str[i]))
     {
	newstr[i-1]=str[i];
	newstr[i]=' ';
     }
  }
  
  fclose(fp);
  char opname[10] = "spe";
  strcat(opname,"b");
  strcat(opname,".txt");
  fp=fopen(opname,"w");
  fputs(newstr, fp);
  fclose(fp);

char shname[10] = "DB/spe";
  strcat(shname,"b");
  strcat(shname,".sh");

FILE *fp2,*fp1;
fp2 =fopen(opname,"r");
fp1 =fopen(shname,"w");
char ch[5];
char str2[35];
fscanf(fp2,"%s",ch);
fprintf(fp1,"%s","sndfile-concat ");
while(!feof(fp2)) {
	strcpy(str2,"/root/Desktop/tts/DB/");
	strcat(str2,ch);
	strcat(str2,".wav ");
	
	fprintf(fp1,"%s",str2);
	strcpy(str2,"");
	fscanf(fp2,"%s",ch);}
fprintf(fp1,"%s","outputb.wav;");
fclose(fp2);
fclose(fp1);


}
else if (spu_id == 2) {
char filename[10] = "output";
  
  FILE *fp;
  strcat(filename,"c");
  strcat(filename,".txt");
 
  
fp = fopen("outputc.txt","r");

  fseek(fp, 0L, SEEK_END);
  int sz = ftell(fp);
  fseek(fp, 0L, SEEK_SET);
 
  char *str = (char *)malloc(sz);
  fgets(str, sz, fp);

  int i;
  char newstr[strlen(str)];
  for(i=0; i<strlen(newstr); i++)
  {
     newstr[i]=" ";
  }
  for(i=0; i<strlen(str); i++)
  {
     newstr[i]=str[i];
     if(isdigit((int)str[i]))
     {
	newstr[i-1]=str[i];
	newstr[i]=' ';
     }
  }
  
 
  fclose(fp);
  char opname[10] = "spe";
  strcat(opname,"c");
  strcat(opname,".txt");
  fp=fopen(opname,"w");
  fputs(newstr, fp);
  fclose(fp);

char shname[10] = "DB/spe";
  strcat(shname,"c");
  strcat(shname,".sh");

FILE *fp2,*fp1;
fp2 =fopen(opname,"r");
fp1 =fopen(shname,"w");
char ch[5];
char str2[35];
fscanf(fp2,"%s",ch);
fprintf(fp1,"%s","sndfile-concat ");
while(!feof(fp2)) {
	strcpy(str2,"/root/Desktop/tts/DB/");
	strcat(str2,ch);
	strcat(str2,".wav ");
	
	fprintf(fp1,"%s",str2);
	strcpy(str2,"");
	fscanf(fp2,"%s",ch);}
fprintf(fp1,"%s","outputc.wav;");
fclose(fp2);
fclose(fp1);


}
else if (spu_id == 3) {
char filename[10] = "output";
 
  FILE *fp;
  strcat(filename,"d");
  strcat(filename,".txt");
  
  
fp = fopen("outputd.txt","r");

  fseek(fp, 0L, SEEK_END);
  int sz = ftell(fp);
  fseek(fp, 0L, SEEK_SET);
 
  char *str = (char *)malloc(sz);
  fgets(str, sz, fp);

  int i;
  char newstr[strlen(str)];
  for(i=0; i<strlen(newstr); i++)
  {
     newstr[i]=" ";
  }
  for(i=0; i<strlen(str); i++)
  {
     newstr[i]=str[i];
     if(isdigit((int)str[i]))
     {
	newstr[i-1]=str[i];
	newstr[i]=' ';
     }
  }
  
  fclose(fp);
  char opname[10] = "spe";
  strcat(opname,"d");
  strcat(opname,".txt");
  fp=fopen(opname,"w");
  fputs(newstr, fp);
  fclose(fp);

char shname[10] = "DB/spe";
  strcat(shname,"d");
  strcat(shname,".sh");

FILE *fp2,*fp1;
fp2 =fopen(opname,"r");
fp1 =fopen(shname,"w");
char ch[5];
char str2[35];
fscanf(fp2,"%s",ch);
fprintf(fp1,"%s","sndfile-concat ");
while(!feof(fp2)) {
	strcpy(str2,"/root/Desktop/tts/DB/");
	strcat(str2,ch);
	strcat(str2,".wav ");
	
	fprintf(fp1,"%s",str2);
	strcpy(str2,"");
	fscanf(fp2,"%s",ch);}
fprintf(fp1,"%s","outputd.wav;");
fclose(fp2);
fclose(fp1);


}

else if (spu_id == 3) {
char filename[10] = "output";
  
  FILE *fp;
  strcat(filename,"d");
  strcat(filename,".txt");
  
fp = fopen("outputd.txt","r");

  fseek(fp, 0L, SEEK_END);
  int sz = ftell(fp);
  fseek(fp, 0L, SEEK_SET);
 
  char *str = (char *)malloc(sz);
  fgets(str, sz, fp);


  int i;
  char newstr[strlen(str)];
  for(i=0; i<strlen(newstr); i++)
  {
     newstr[i]=" ";
  }
  for(i=0; i<strlen(str); i++)
  {
     newstr[i]=str[i];
     if(isdigit((int)str[i]))
     {
	newstr[i-1]=str[i];
	newstr[i]=' ';
     }
  }
  
 
  fclose(fp);
  char opname[10] = "spe";
  strcat(opname,"d");
  strcat(opname,".txt");
  fp=fopen(opname,"w");
  fputs(newstr, fp);
  fclose(fp);

char shname[10] = "DB/spe";
  strcat(shname,"d");
  strcat(shname,".sh");

FILE *fp2,*fp1;
fp2 =fopen(opname,"r");
fp1 =fopen(shname,"w");
char ch[5];
char str2[35];
fscanf(fp2,"%s",ch);
fprintf(fp1,"%s","sndfile-concat ");
while(!feof(fp2)) {
	strcpy(str2,"/root/Desktop/tts/DB/");
	strcat(str2,ch);
	strcat(str2,".wav ");
	
	fprintf(fp1,"%s",str2);
	strcpy(str2,"");
	fscanf(fp2,"%s",ch);}
fprintf(fp1,"%s","outputd.wav;");
fclose(fp2);
fclose(fp1);


}
else if (spu_id == 4) {
char filename[10] = "output";
  
  FILE *fp;
  strcat(filename,"e");
  strcat(filename,".txt");
  
fp = fopen("outpute.txt","r");

  fseek(fp, 0L, SEEK_END);
  int sz = ftell(fp);
  fseek(fp, 0L, SEEK_SET);
 
  char *str = (char *)malloc(sz);
  fgets(str, sz, fp);

  int i;
  char newstr[strlen(str)];
  for(i=0; i<strlen(newstr); i++)
  {
     newstr[i]=" ";
  }
  for(i=0; i<strlen(str); i++)
  {
     newstr[i]=str[i];
     if(isdigit((int)str[i]))
     {
	newstr[i-1]=str[i];
	newstr[i]=' ';
     }
  }

  fclose(fp);
  char opname[10] = "spe";
  strcat(opname,"e");
  strcat(opname,".txt");
  fp=fopen(opname,"w");
  fputs(newstr, fp);
  fclose(fp);

char shname[10] = "DB/spe";
  strcat(shname,"e");
  strcat(shname,".sh");

FILE *fp2,*fp1;
fp2 =fopen(opname,"r");
fp1 =fopen(shname,"w");
char ch[5];
char str2[35];
fscanf(fp2,"%s",ch);
fprintf(fp1,"%s","sndfile-concat ");
while(!feof(fp2)) {
	strcpy(str2,"/root/Desktop/tts/DB/");
	strcat(str2,ch);
	strcat(str2,".wav ");
	
	fprintf(fp1,"%s",str2);
	strcpy(str2,"");
	fscanf(fp2,"%s",ch);}
fprintf(fp1,"%s","outpute.wav;");
fclose(fp2);
fclose(fp1);


}

else if (spu_id == 5) {
char filename[10] = "output";
  
  FILE *fp;
  strcat(filename,"f");
  strcat(filename,".txt");
   
fp = fopen("outputf.txt","r");

  fseek(fp, 0L, SEEK_END);
  int sz = ftell(fp);
  fseek(fp, 0L, SEEK_SET);
 
  char *str = (char *)malloc(sz);
  fgets(str, sz, fp);

  int i;
  char newstr[strlen(str)];
  for(i=0; i<strlen(newstr); i++)
  {
     newstr[i]=" ";
  }
  for(i=0; i<strlen(str); i++)
  {
     newstr[i]=str[i];
     if(isdigit((int)str[i]))
     {
	newstr[i-1]=str[i];
	newstr[i]=' ';
     }
  }
 
  fclose(fp);
  char opname[10] = "spe";
  strcat(opname,"f");
  strcat(opname,".txt");
  fp=fopen(opname,"w");
  fputs(newstr, fp);
  fclose(fp);

char shname[10] = "DB/spe";
  strcat(shname,"f");
  strcat(shname,".sh");

FILE *fp2,*fp1;
fp2 =fopen(opname,"r");
fp1 =fopen(shname,"w");
char ch[5];
char str2[35];
fscanf(fp2,"%s",ch);
fprintf(fp1,"%s","sndfile-concat ");
while(!feof(fp2)) {
	strcpy(str2,"/root/Desktop/tts/DB/");
	strcat(str2,ch);
	strcat(str2,".wav ");
	
	fprintf(fp1,"%s",str2);
	strcpy(str2,"");
	fscanf(fp2,"%s",ch);}
fprintf(fp1,"%s","outputf.wav;");
fclose(fp2);
fclose(fp1);

}





 /* int count ;
FILE *input, *focusWords, *output, *afocusFile ;
char inputName[50],outputName[50];
sprintf(inputName,"/home/10a/Desktop/sample/input%d.txt",spu_id);
sprintf(outputName,"/home/10a/Desktop/sample/output%d.txt",spu_id);


input = fopen(inputName,"r");
output = fopen(outputName,"w");

printf("\n%s,%s\n",inputName,outputName);

focusWords = fopen("/home/10a/Desktop/sample/focus.txt","r");
afocusFile = fopen("/home/10a/Desktop/sample/focus1.txt","r");

char line[1000];
char focus[100][100];
char afocus[100][100];
int i = 0,j,n,m;
while(fgets(line,sizeof line, focusWords)!=NULL){
	for(j=0;line[j]!='\n';j++)
		focus[i][j] = line[j];
	focus[i++][j] = '\0';
}
n = i;i=0;
while(fgets(line,sizeof line, afocusFile)!=NULL){
	for(j=0;line[j]!='\n';j++)
		afocus[i][j] = line[j];
	afocus[i++][j] = '\0';
}
m=i;

if(n!=0){

	while(fgets(line,sizeof line, input)!=NULL){
		count = 0;
		for(i=0;i<n;i++){
			if(strstr(line,focus[i])!=NULL)
				count++;
		}
		if(count>0){
			for(i=0;i<m;i++){
			if(strstr(line,afocus[i])!=NULL)
				count++;
			}
			fprintf(output,"%d %s",count,line);
		}
	}
}else{
	while(fgets(line,sizeof line, input)!=NULL){
		count = 0;
		for(i=0;i<m;i++){
			if(strstr(line,afocus[i])!=NULL)
				count++;
		}
		if(count>0)
			fprintf(output,"%d %s",count,line);
	}
} */

return 0;
}
