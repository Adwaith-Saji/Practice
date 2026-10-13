
# Distance Vector Routing with 4 Nodes
# Demonstration of Count-to-Infinity

# Create simulator
set ns [new Simulator]

# Create NAM trace file
set nf [open dv.nam w]
$ns namtrace-all $nf

# Create 4 nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

# Create links between nodes
$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns duplex-link $n2 $n3 1Mb 10ms DropTail
$ns duplex-link $n0 $n3 1Mb 30ms DropTail

# Enable Distance Vector routing
$ns rtproto DV

# Schedule link failure
$ns rtmodel-at 20.0 down $n1 $n2

# Restore link later
$ns rtmodel-at 80.0 up $n1 $n2

# Finish simulation
proc finish {} {
    global ns nf
    $ns flush-trace
    close $nf
    exec nam dv.nam &
    exit 0
}

$ns at 100.0 "finish"

# Run simulation
$ns run
