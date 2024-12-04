# Discord server ip notificator
## What does it do
On startup this program looks for the public address of the device. After the startup message this address is send as a message to all the provided Discord webhooks. In the provided intervall the application checks for the address again and compares it for changes. After a address change is detected, the new address is again send over the webhooks.

## Which problem does this solve
If you have a server/device you can reach over a ipv4 address which isn´t static and changes sometimes. This application helps you getting the new address whitout you being present in the network of the server/device.

## How to use
1. Download the project.
2. Compile the project to an executable program.
3. execute the program with two parameters.
- 1. first to second to last parameter: Discord Webhook addresses.
- 2. last parameter: Intervall in seconds in which the application should check for a new address.
