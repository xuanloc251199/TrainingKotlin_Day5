package com.fpt.day5

data class HostConfig(
    val hcIp: String,
    val hcName: String,
    val hcPort: Int,
    val hcTypeConn: TypeConn
)

class ManagerHostConfig {

    var lstHostConfig = mutableListOf<HostConfig>()

    private lateinit var typeConn: TypeConn

    private fun addHostConfig(hostConfig: HostConfig) {
        lstHostConfig.add(hostConfig)
    }

    fun inputHostConfig() {
        var n: Int
        while (true) {
            println("Input number of list Host Config (ip, name, port, type connection):")
            n = try {
                readln().toInt() ?: 0
            } catch (e: Exception) {
                println("Please input the number!!!")
                -1
            }

            when {
                n <= 3 -> break
                else -> {
                    println("Please choose one of 1, 2, 3")
                    continue
                }
            }
        }
        for (i in 1..n) {
            println("Host Config: $i")
            print("Ip: ")
            val ip = readLine().toString()
            print("Name: ")
            val name = readLine().toString()
            print("Port: ")
            val port = readln().toInt()

            println("Choose type connection:")
            println("1.Wifi")
            println("2.4G")
            println("3.Other")

            while (true) {

                when (readln().toInt()) {
                    1 -> {
                        typeConn = TypeConn.WIFI
                        break
                    }
                    2 -> {
                        typeConn = TypeConn.DATA
                        break
                    }
                    3 -> {
                        typeConn = TypeConn.OTHER
                        break
                    }

                    else -> {
                        println("Choose 1, 2 or 3")
                        continue
                    }
                }
            }
            addHostConfig(HostConfig(ip, name, port, typeConn))
            for (j in 1 until n) {
                addHostConfig(HostConfig(ip, name, port + j, typeConn))
            }

        }
    }

    fun getAllListHostConfig() {
        println("List Host Config:")
        for (i in 1 until lstHostConfig.size) {
            println(lstHostConfig[i])
        }
    }

    fun getListHostConfigByIp() {
        println("Enter ip: ")
        val ip = readLine().toString()
        val lstHostConfigByIp = mutableListOf<HostConfig>()
        for (i in 0 until lstHostConfig.size) {
            if (lstHostConfig[i].hcIp == ip) {
                lstHostConfigByIp.add(lstHostConfig[i])
            }

            if (lstHostConfigByIp.isEmpty()) {
                println("Haven't Host Config with ip: $ip")
            } else {
                for (i in 0 until lstHostConfigByIp.size) {
                    println("$i: ${lstHostConfigByIp[i]}")
                }
            }
        }
    }

    fun getListHostConfigByName() {
        println("Enter Name: ")
        val name = readLine().toString()
        val lstHostConfigByName = mutableListOf<HostConfig>()
        for (i in 0 until lstHostConfig.size) {
            if (lstHostConfig[i].hcName == name) {
                lstHostConfigByName.add(lstHostConfig[i])
            }

            if (lstHostConfigByName.isEmpty()) {
                println("Haven't Host Config with name: $name")
            } else {
                for (i in 0 until lstHostConfigByName.size) {
                    println("$i: ${lstHostConfigByName[i]}")
                }
            }
        }
    }

    fun getListHostConfigByPort() {
        println("Enter Port: ")
        val port = readLine()
        val lstHostConfigByPort = mutableListOf<HostConfig>()
        for (i in 0 until lstHostConfig.size) {
            if (lstHostConfig[i].hcPort.toString() == port) {
                lstHostConfigByPort.add(lstHostConfig[i])
            }

            if (lstHostConfigByPort.isEmpty()) {
                println("Haven't Host Config with port: $port")
            } else {
                for (i in 0 until lstHostConfigByPort.size) {
                    println("$i: ${lstHostConfigByPort[i]}")
                }
            }
        }
    }

    fun getListHostConfigByType() {

        val lstHostConfigByType = mutableListOf<HostConfig>()
        val type: TypeConn

        println("Enter Type: ")
        println("1.Wifi")
        println("2.4G")
        println("3.Other")
        while (true) {

            when (readln().toInt()) {
                1 -> {
                    type = TypeConn.WIFI
                    break
                }
                2 -> {
                    type = TypeConn.DATA
                    break
                }
                3 -> {
                    type = TypeConn.OTHER
                    break
                }

                else -> {
                    println("Choose 1, 2 or 3")
                    continue
                }
            }
        }

        for (i in 0 until lstHostConfig.size) {
            if (lstHostConfig[i].hcTypeConn == type) {
                lstHostConfigByType.add(lstHostConfig[i])
            }

            if (lstHostConfigByType.isEmpty()) {
                println("Haven't Host Config with type: $type")
            } else {
                for (i in 0 until lstHostConfigByType.size) {
                    println("$i: ${lstHostConfigByType[i]}")
                }
            }
        }
    }
}