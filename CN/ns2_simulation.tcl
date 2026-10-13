# Step 1: Create a Simulator object
set ns [new Simulator]

# Step 2: Create trace files
set tracefile [open out.tr w]
$ns trace-all $tracefile

set namfile [open out.nam w]
$ns namtrace-all $namfile

# Step 3: Create two nodes
set n0 [$ns node]
set n1 [$ns node]

# Step 4: Create a duplex link
$ns duplex-link $n0 $n1 1Mb 10ms DropTail

# Step 5: Create and attach UDP agent
set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0

# Step 6: Create and attach Null agent
set null0 [new Agent/Null]
$ns attach-agent $n1 $null0

# Step 7: Connect the agents
$ns connect $udp0 $null0

# Step 8: Create and configure CBR traffic
set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

# Step 9: Schedule events
$ns at 0.5 "$cbr0 start"
$ns at 4.5 "$cbr0 stop"
$ns at 5.0 "finish"

# Step 10: Define the finish procedure
proc finish {} {
    global ns tracefile namfile
    $ns flush-trace
    close $tracefile
    close $namfile
    exec nam out.nam &
    exit 0
}

# Step 11: Run the simulation
$ns run