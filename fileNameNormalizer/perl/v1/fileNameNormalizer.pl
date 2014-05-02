use strict;
use warnings;

use Data::Dump qw(dump);
use File::Basename;

sub println{
    my($my) = @_;
    print $my."\n";
}

{
    my @changed;
    my @notChanged;
            
    
    sub getFiles{
        my($folder) = shift;
        my @fullPathFiles = glob($folder."/*");
        my @files;
        foreach (@fullPathFiles) {
            if (-f $_){
                my $filename = fileparse($_);
                push(@files, $filename); 
            }
        };
        return @files;
    }
    
    sub normalize{
        my($filename) = shift;
        if ($filename =~ /(^[a-z_A-Z]+?)[-|_]?(\d+)([-|_]?)([a-cA-C]?)(r?pl)?[d-zD-Z,]?\s*\.(\w+)$/){
            $filename = uc($1)."-".&normalizeNumber($2);
            if (length($4) > 0){
                $filename .= uc("_".$4).".".lc($6);
            }else{
                $filename .= ".".lc($6);
            }
            push @changed, $filename;
        }else{
            push @notChanged, $filename;
        }
        return $filename;
    }

    # shorten the number from 00003 to 003
    # remove zeroes only
    sub normalizeNumber{
        my $number = shift;
        $number = $number + 0;
        if ($number < 100 and $number >= 10){
            $number = "0".$number;
        }elsif ($number < 10 and $number > 0){
            $number = "00".$number;
        }
        return $number;
    }
    
    sub renameFolder{
        my $folder = shift;
        foreach (getFiles($folder)){
            my $from = "$folder/$_";
            my $to = "$folder/".normalize($_);
            if ($to eq $from){
                #do nothing
            }elsif (-e $to){
                println ("Cannot rename [$from], file [$to] already exists!");
            }else{
                rename($from, $to);
            }
        };
    }
    
    sub printSummary{
        println("\n-------------Changed-------------");
        print($_."\n") foreach @changed;
        println("\n\n-------------Not Changed-------------");
        print($_."\n") foreach @notChanged;
        println("\n");
    }

    
    sub testSingle{
        my @inputs = ("abc001.avi", "etf-123.mp4", "001-124.avi",
            "abef-213r.gif", "eft-124a.jpg", "GFE-123-b.rmvb",
            "abs-104pl.jpg", "EKDV-152 .jpg", "mide023,.avi",
            "MILD_753.jpg", "sadr-052rpl.jpg", "ZDAD-28_ENG_01.rmvb",
            "COSQ-017_1.rmvb", "ENFD-5401 Extra.rmvb", "heyzo_lt_0203.jpg",
            "abs-55a.avi", "abs-56_a.avi", "cosq00009pl.jpg", "cosq00019pl.jpg");
            
        my @expected = ("ABC-001.avi", "ETF-123.mp4", "001-124.avi",
            "ABEF-213.gif", "EFT-124_A.jpg", "GFE-123_B.rmvb",
            "ABS-104.jpg", "EKDV-152.jpg", "MIDE-023.avi",
            "MILD-753.jpg", "SADR-052.jpg", "ZDAD-28_ENG_01.rmvb",
            "COSQ-017_1.rmvb", "ENFD-5401 Extra.rmvb", "HEYZO_LT-203.jpg",
            "ABS-055_A.avi", "ABS-056_A.avi", "COSQ-009.jpg", , "COSQ-019.jpg");
            
        sub assertEqual{
            my($actual, $expected) = @_;
            if ($actual ne $expected){
                println("Case failed, got: [$actual] while expect: [$expected]");
            }
        }
        
        for (my $i = 0 ; $i <= $#inputs ; $i++){
            my $actual = &normalize($inputs[$i]);
            &assertEqual($actual, $expected[$i]);
            #println("$inputs[$i]  -->  $actual");
        }
        
        &printSummary();
    }
    

    sub testGetFiles{
        println $_ foreach getFiles('../..');
    }
    
    sub testRenameFolder{
        renameFolder("test");
    }

    sub run{
        renameFolder('c:\work\a');
        #renameFolder('e:\normal');
        printSummary();
        
    }
    
    # testGetFiles();
    # testSingle();
    # testRenameFolder();
    
    run();
}


