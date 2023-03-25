


# CokeMachine-Simulation

# MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

#Coke Machine Simulation

This repository contains a Java implementation of a coke machine simulation program.

#Table of Contents
#Description
#Prerequisites
#Installation
#Usage
#Contributing
#License

#Description
The CokeMachine class models a basic coke machine with a set inventory level, change level, and coke price. It can perform actions such as dispensing change, checking inventory levels, and selling a coke.

The Code3_1001844964 class contains the main method for running the coke machine simulation. It presents the user with a menu of options to choose from, such as buying a coke or restocking the machine.

#Prerequisites
To run this program, you will need:
Java Development Kit (JDK) 8 or later

#Installation

To install and run the program:

Clone or download this repository to your local machine.
Open a terminal or command prompt in the project directory.
Compile the Java source files using the command: javac code3_1001844964/*.java
Run the program using the command: java code3_1001844964.Code3_1001844964

#Usage
Upon running the program, you will be presented with a menu of options to choose from. The options are:

Walk away
Buy a Coke
Restock Machine
Add change
Display Machine Info
Buy a Coke

Selecting option 1 will prompt you to enter your payment. The program will then check if the payment is sufficient and if there is enough inventory to sell a coke. If everything is in order, a coke will be dispensed, and change will be given if necessary.

Restock Machine
Selecting option 2 will prompt you to enter the number of cokes you want to add to the machine's inventory. If the machine already has the maximum inventory level, the restock will fail.

Add change
Selecting option 3 will prompt you to enter the amount of change you want to add to the machine's change level. If the machine already has the maximum change capacity, the add change action will fail.

Display Machine Info
Selecting option 4 will display the current state of the coke machine, including its name, inventory level, change level, and the number of cokes sold.

Walk away
Selecting option 0 will exit the program.

#Contributing
Contributions to this project are welcome. To contribute, please fork this repository, create a feature branch, and submit a pull request.
