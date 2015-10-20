#!/usr/bin/perl

print "Compute your car's MPG!\n";

my $tripCount = 1;
my $gallons = 0;
my $miles = 0;
$getInput = 1;

while($getInput)
{
	if($tripCount==1)
	{
		print "Trip $tripCount\: Enter number of gallons used:\n";
		$gallons = <STDIN>;
		chomp $gallons;
		$totalGallons += $gallons;
	}
	else
	{
		print "Trip $tripCount\: Enter number of gallons used or -1 to quit:\n";
		$gallons = <STDIN>;
		chomp $gallons;
		if($gallons==-1)
		{
			$getInput = 0;
			last;
		}
		$totalGallons += $gallons;
	}

	print "Enter number of miles driven:\n";
	$miles = <STDIN>;
	chomp $miles;
	$totalMiles += $miles;

	$tripCount++;
}

$MPG = $totalMiles/$totalGallons;

print "Your vehicle got an average of $MPG miles per gallon in $tripCount trips.\n";
