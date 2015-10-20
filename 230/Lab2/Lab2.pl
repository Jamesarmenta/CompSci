open(INF, "<", "infile.txt") or die "couldn't open input file\n";

{
local $/;
$inBuffer = <INF>;
}

# then, you can process $inBuffer as the contents of the file
#Regex splits to new element everytime it is not a-z A-Z or '
my @wordArray = split /[^a-z|A-Z|\']+/, $inBuffer;

#print my array
=pod
foreach my $word (@wordArray) 
{
  print "$word\n";
}
=cut

my ($temp, $count) = ("@wordArray", 0);
($count = $temp =~ s/($_)//g) and printf "%2d:%s\n\n", $count, $_ for @wordArray;