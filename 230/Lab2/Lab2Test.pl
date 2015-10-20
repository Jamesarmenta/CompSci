 $matchSentence = "dog 62*21 equals 98127";

 if ($matchSentence =~ m/(\d+)\s*\*\s*(\d+)/)
 {
	print "MATCHES\n"; 

	print  "		\$` = '$`'\n
      		\$& = '$&'\n
      		\$' = '$''\n
      		\$1 = '$1'\n
      		\$2 = '$2'\n
      		\$3 = '$3'\n\n"
 }
 else
 {
 	print "DOES NOT MATCH\n";
 }