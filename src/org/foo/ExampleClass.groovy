import org.yaml.snakeyaml.Yaml

class ExampleClass {
    def runCommandFromYaml(String yamlInput) {
        // Parse YAML input
        def yaml = new Yaml()
        def data = yaml.load(yamlInput)
        def command = data?.command

        if (!command) {
            throw new IllegalArgumentException("YAML must contain a 'command' key")
        }

        def process = ["sh", "-c", command].execute()
        def output = new StringBuffer()
        def error = new StringBuffer()

        process.consumeProcessOutput(output, error)
        def exitCode = process.waitFor()

        return [output: output.toString(), exitCode: exitCode, error: error.toString()]
    }
}