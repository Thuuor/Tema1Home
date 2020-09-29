package Exercicis
//tema 1 home patrick martinez romero
import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
	var f = File.listRoots()[0]
	var ent = -2

	printList(f)

	while (ent != -1) {
		println("Introduce el numero del directorio: (escribe -1 para cerrar el programa): ")
		ent = readLine()!!.toInt() as Int


		if (ent == 0) {
			if (f.getParentFile().exists()) {
				f = File(f.getParent())
				printList(f)
			} else {
				println("El directorio padre no existe")
			}
		} else {
			if (f.isDirectory() && f.canRead()) {
				f = File(f.listFiles().elementAt(ent - 1).getPath())

				printList(f)
			}
		}
	}
}


fun printList(f: File) {
	val string = "Llista de fitxers i directoris del directori " + f
	println(string)
	println("-".repeat(string.length))

	println("0.- Directori pare")
	var count = 1
	for (e in f.listFiles().sorted()) {
		print(count.toString() + ".- ")
		if (e.isFile())
			println(e.getName() + "\t " + e.length())
		if (e.isDirectory())
			println(e.getName() + "\t <Directori>")
		count++
	}
}

