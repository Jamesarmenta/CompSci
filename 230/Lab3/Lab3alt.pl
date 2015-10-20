open(INF, "<", "infile.txt") or die "couldn't open input file\n";

{
  local $/;
  $inBuffer = <INF>;
}

#my @lexemeArray = split /[\s]+/, $inBuffer;

$lexemeString = $inBuffer;

$processString = 1;

$knownSymbols = "\=|\=\=|\+|\-|\*|\{|\}|\;";
$knownKeywords = "program|while|begin|end|for|if|else|and|or|not";

while($processString)
{
	#skip if whitespace or new line
	if($lexemeString =~ m/^[\s|\n]/)
	{
		$lexemeString = $';
	}
	#print if approved word
	elsif($lexemeString =~ m/^(($knownKeywords){1})(\=|\=\=|\+|\-|\*|\{|\}|\;|\(|\))*/)
	{
		print "KNOWN KEYWORD: $2\n";
		$lexemeString = $3.$';
	}
	#print if approved symbol
	elsif($lexemeString =~ m/^(\=|\=\=|\+|\-|\*|\{|\}|\;)/)
	{
		print "KNOWN SYMBOL: $1\n";
		$lexemeString = $';
	}
	#finish if empty string
	elsif($lexemeString =~ m/^$/)
	{
		print "COMPLETE\n\n";
		$processString = 0;
	}
	else
	{
		#print if unknown symbol
		if($lexemeString =~ m/^(\S+)/)
		{
			print "UNKNOWN LEXEME: $1\n";
			$lexemeString = $';
		}
	}
}

