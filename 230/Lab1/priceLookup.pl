my $filename = 'prodPrices.txt';

open(my $fh, '<:encoding(UTF-8)', $filename)
  or die "Could not open file '$filename' $!";

my @foodPrices;
my %foodHash;

while (my $row = <$fh>) 
{
  chomp $row;

  if($row !~ /eof/)
  {
  	push(@foodPrices, "$row");
  }
}

$i = 0; 
for ($i = 0; $i < (scalar (@foodPrices)-1); $i+=2)
{
	$foodHash{$foodPrices[$i]} = $foodPrices[$i+1];
}

#get user input
print "Search for a product's price. Type 'quit' to terminate the program.\n";
#getInput
$input = <>;
#Chomp return character
chomp($input);

#What did I input?
print "You said:'$input'\n";

#Do they want to quit?
if ($input =~ /quit/i)
{
	print "The program has terminated\n\n";
	exit;
}
foreach $key (%foodHash)
{
	if ($key =~ /$input/i)
	{
		print "The price for $input is $foodHash{$key}\n";
		$productFound = true;
	}
}
if (!productFound)
{
	print "$input not available\n";
}


