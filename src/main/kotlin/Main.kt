package com.example.praktikum

import java.util.Scanner

//ARCHIVE -> NOTE -> CREATE -> VIEW
fun main() {
    val archiveList = mutableListOf<Archive>()
    val scanner = Scanner(System.`in`)
    val menu = Menu()
    var menuState = MenuState.ARCHIVE
    var selectedArchiveIndex = -1
    var selectedNoteIndex = -1
    while (true) {
        when (menuState) {
            MenuState.ARCHIVE -> menu.render(archiveList, "Архив")
            MenuState.NOTES -> menu.render(archiveList[selectedArchiveIndex].notes, "Записку")
            MenuState.VIEW -> {
                if (selectedArchiveIndex >= 0 && selectedNoteIndex >= 0) {
                    println(archiveList[selectedArchiveIndex].notes[selectedNoteIndex])
                }
                scanner.nextLine()
                menuState = MenuState.NOTES
                continue
            }

            MenuState.CREATE -> {
                when {
                    selectedArchiveIndex < 0 -> {
                        println("Введите название Архива")
                        val name = scanner.nextLine()
                        archiveList.add(Archive(name, mutableListOf()))
                        menuState = MenuState.ARCHIVE
                        continue
                    }

                    selectedArchiveIndex >= 0 -> {
                        println("Введите имя Записки")
                        val name = scanner.nextLine()
                        println("Введите текст записки")
                        val body = scanner.nextLine()
                        archiveList[selectedArchiveIndex].notes.add(Note(name, body))
                        menuState = MenuState.NOTES
                        continue
                    }
                }

            }
        }
        val selectedIndex = scanner.nextLine().toInt()
        when {
            selectedIndex == 0 -> menuState = MenuState.CREATE
            selectedIndex < menu.menuItems.lastIndex -> {
                when (menuState) {
                    MenuState.ARCHIVE -> {
                        selectedArchiveIndex = selectedIndex - 1
                        menuState = MenuState.NOTES
                    }

                    MenuState.NOTES -> {
                        selectedNoteIndex = selectedIndex - 1
                        menuState = MenuState.VIEW
                    }

                    else -> {/*do nothing*/
                    }
                }
            }

            selectedIndex == menu.menuItems.lastIndex -> {
                when (menuState) {
                    MenuState.NOTES -> menuState = MenuState.ARCHIVE
                    else -> return
                }
            }
        }
    }
}