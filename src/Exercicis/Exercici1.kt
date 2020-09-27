package Exercicis
//tema 1 home patrick martinez romero
import java.io.File
import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
	var f = File.listRoots()[0]


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

	println("Introduce el numero del directorio: (escribe -1 para cerrar el programa): ")

	var ent = BufferedReader(InputStreamReader(System.`in`)).readLine()
	if (ent == "-1") {
		System.exit(0)
	} else {
		if (ent == "0") {
			var numDir = f.listFiles().sorted()[Integer.parseInt(ent) - 1]
			f = numDir
			f = f.getParentFile()
			if (f.exists()) {
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
			} else {
				println("El directorio padre no existe")
			}
		} else {
			var numDir = f.listFiles().sorted()[Integer.parseInt(ent) - 1]
			if (numDir.isDirectory() && numDir.canRead()) {
				f = numDir

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
		}
	}
}

