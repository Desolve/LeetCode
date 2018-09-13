# Read from the file file.txt and output the tenth line to stdout.
#tail -n+10 file.txt| head -n1
#sed -n '10p' file.txt
awk 'NR == 10{print;exit}' file.txt

#LINE_NUM=`head -n 10 file.txt | wc -l`
#
#if (( $LINE_NUM == "10" )); then
#    head -n 10 file.txt | tail -n 1 
#fi