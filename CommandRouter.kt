object CommandRouter{
	  fun run(args : Array<String>){
		  val command = args.firstOrNull()
		  when(command){
			  "today" -> Commands.today()
			  else -> println("Usage : bulan [today]")
		  }
	  }
  }
