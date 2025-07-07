import org.foo.ExampleClass
import spock.lang.Specification

class ExampleClassTest extends Specification {

    def "test exampleMethod"() {
        setup:
        def exampleClass = new ExampleClass()

        when:
        def result = exampleClass.exampleMethod()

        then:
        result == "expectedResult" // Replace with the actual expected result
    }
}