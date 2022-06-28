package com.fpt.day5


// Users input a list Host Config (ip, port, type connection) (min 4 items). Each Entered Host
//Config will generate 3 Host Configs include ip, type connection and port + 1 automatically.

val managerHostConfig = ManagerHostConfig()

fun main() {

    managerHostConfig.inputHostConfig()

    userSelection()



}

private fun reselect() {

    println("Do u want continue?")
    println("1.Yes")
    println("2.No")

    while (true){
        when(readln().toInt()){
            1 -> userSelection()
            2 -> break
        }
    }

}
private fun userSelection() {
    println("Show information of all host config in list with one of the following conditions: ")
    println("1.Ip")
    println("2.Name")
    println("3.Port")
    println("4.Type Connection")
    println("5.Get all")
    print("Choose your selection (1, 2, 3, 4, 5): ")
    while (true) {
        when (readln().toInt()) {
            1 -> {
                managerHostConfig.getListHostConfigByIp()
                reselect()
                break
            }
            2 -> {
                managerHostConfig.getListHostConfigByName()
                reselect()
                break
            }
            3 -> {
                managerHostConfig.getListHostConfigByPort()
                reselect()
                break
            }
            4 -> {
                managerHostConfig.getListHostConfigByType()
                reselect()
                break
            }
            5 -> {
                managerHostConfig.getAllListHostConfig()
                reselect()
                break
            }
            else -> {
                println("Please choose one of 1, 2, 3, 4, 5")
                continue
            }
        }
    }
}


