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

        // Build Docker command
        def cmd = "sh -c '${command}'"
        def process = cmd.execute()
        def output = process.text
        def exitCode = process.waitFor()

        return [output: output, exitCode: exitCode]
    }
}