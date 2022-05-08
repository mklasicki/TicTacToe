dim AppRunCmd
dim Path
dim AppName

AppName = "TicTacToe.jar"
Path = "target\"
AppRunCmd = "java -jar " & chr(34) & Path & AppName & chr(34)

Set WshShell = CreateObject("WScript.Shell")

WshShell.Run "java -jar target\TicTacToe.jar"