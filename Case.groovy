package CodeJam16.JamTools

import groovy.transform.CompileStatic

/**
 * Created by Andrew on 3/24/2016.
 */
@CompileStatic
abstract class Case {

    int caseNumber
    List<String> data

    Case(List<String> data, int caseNumber) {
        this.caseNumber = caseNumber
        this.data = data
    }

    abstract String solve();

    String toString() {
        "Case #$caseNumber: ${solve()}"
    }

}
