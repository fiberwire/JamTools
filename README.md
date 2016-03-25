# JamTools
Framework to make Google Code Jam easier

to add a new problem:

        1. make a class that extends from Problem

        2. make a class that extends from Case to go along with your problem class

        3. implement parseData in your Problem class
        It should take a list of strings and return an instance of your case class

        4. Implement solve() in your Case class
        It should calculate and return the solution (the part that comes after "Case #X:"

        5. in the constructor of your Problem class, call Solve(this.&parseData) to solve both sizes of problem
        this.&parseData passes the parseData method as a closure to Solve()

        6. Put the input files in the Input folder.
        input files should begin with the name of your Problem class
        Small input should end with _Small.in, large should end with _Large.in

        7. Make a new instance of your Problem class in main()
