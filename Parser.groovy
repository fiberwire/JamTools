package CodeJam16.JamTools

import groovy.transform.CompileStatic

@CompileStatic
class Parser {

    File file

    static final String inputDir = "D:\\Projects\\Groovy\\CodeJam16\\src\\CodeJam16\\Input"

    int linesPerCase

    int getNumCases() {
        file.readLines().first().toInteger()
    }

    Parser(String fileName, int linesPerCase) {
        file = new File("$inputDir\\$fileName")
        this.linesPerCase = linesPerCase
    }

    /**
     * gets a list of cases from a file
     * @param parseData responsible for returning the specific type of case needed
     * @return list of cases of whichever type parseData() returns
     */
    List<Case> parse(Closure<? extends Case> parseData) {
        List<List<String>> data = file.readLines().drop(1).collate(linesPerCase)
        return data.withIndex().collect { d, int i -> parseData(d, i + 1) } as List<Case>
    }
}
