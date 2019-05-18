# Read from the file file.txt and print its transposed content to stdout.
awk -F' ' ' 
{{for(i=1;i<=NF;i=i+1){array[NR,i]=$i}}} 
END{ 
for(i=1;i<=NF;i++){ 
for(j=1;j<=NR;j++){ 
printf("%s",array[j,i]); 
if(j<NR){printf(" ")} 
}; 
printf("\n") 
} 
}' file.txt