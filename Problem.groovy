package CodeJam16.JamTools

import groovy.transform.CompileStatic
import sun.reflect.generics.reflectiveObjects.NotImplementedException

/**
 * Created by Andrew on 3/24/2016.
 */
@CompileStatic
abstract class Problem {
    static final String outputDir = "D:\\Projects\\Groovy\\CodeJam16\\src\\CodeJam16\\Output"

    String baseFileName
    int numSmallCases, numLargeCases

    Parser sp, lp

    List<Case> sCases, lCases

    public Problem(int linesPerCase) {
        this.baseFileName = this.class.simpleName

        sCases = []
        lCases = []

        sp = new Parser(smallInputFileName, linesPerCase)
        lp = new Parser(largeInputFileName, linesPerCase)

        numSmallCases = sp.numCases
        numLargeCases = lp.numCases
    }

    Case parseData(List<String> data, int caseNumber) {
        throw new NotImplementedException()
    }

    void Solve(Closure<? extends Case> parseData) {
        SolveSmall(parseData)
        SolveLarge(parseData)
    }

    void SolveSmall(Closure<? extends Case> parseData) {
        sCases = sp.parse(parseData)

        sCases.each { println(it) }
        OutputSmall()
    }

    void SolveLarge(Closure<? extends Case> parseData) {
        lCases = lp.parse(parseData)

        lCases.each { println(it) }
        OutputLarge()
    }


    String getSmallInputFileName() {
        "${baseFileName}_Small.in"
    }

    String getLargeInputFileName() {
        "${baseFileName}_Large.in"
    }

    String getSmallOutputFileName() {
        "${baseFileName}_Small.out"
    }

    String getLargeOutputFileName() {
        "${baseFileName}_Large.out"
    }

    void OutputSmall() {
        new File("${outputDir}\\$smallOutputFileName").write(sCases.join("\n"))
    }

    void OutputLarge() {
        new File("${outputDir}\\$largeOutputFileName").write(lCases.join("\n"))
    }
}
