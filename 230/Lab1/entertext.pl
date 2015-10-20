print "Type input. Type 'quit' to terminate the program.\n";

$getInput = true;
while($getInput)
{
	#getInput
	$input = <>;
	#Chomp return character
	chomp($input);
	#What did I input?
	print "You said:'$input'\n";

	#Check for conditions
	#Does it contain Skimore?
	if ($input =~ /Skidmore/i)
	{
		print "•Your input contained 'Skidmore'\n";
	}
	#Does it contain a date?
	if ($input =~ /\d\d\/\d\d\/\d\d\d\d/)
	{
		print "•Your input contained a date!\n";
	}
	#Does it contain a capital letter?
	if ($input =~ /[A-Z]/)
	{
		print "•Your input contained at leat one capital letter!\n";
	}
	#Does it contain a lowercase letter?
	if ($input =~ /[a-z]/)
	{
		print "•Your input contained at leat one lowercase letter!\n";
	}
	#Does it contain a date?
	if ($input =~ /\d\d\/\d\d\/\d\d\d\d/)
	{
		print "•Your input contained a date!\n";
	}

	#Do they want to quit?
	if ($input =~ /quit/i)
	{
		$getInput = false;
		print "The program has terminated\n\n";
		exit;
	}
}