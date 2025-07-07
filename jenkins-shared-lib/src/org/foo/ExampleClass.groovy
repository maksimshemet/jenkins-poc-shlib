import org.yaml.snakeyaml.Yaml

class ExampleClass {
    def runCommandFromYaml(String yamlInput) {
        // Parse YAML input
        def yaml = new Yaml()
        def data = yaml.load(yamlInput)
        def image = data?.image
        def command = data?.command

        if (!command && !image) {
            throw new IllegalArgumentException("YAML must contain a 'command' and 'image' key")
        }

        // Build Docker command
        def dockerCmd = "docker run --rm ${image} sh -c '${command}'"
        def process = dockerCmd.execute()
        def output = process.text
        def exitCode = process.waitFor()

        return [output: output, exitCode: exitCode]
    }
}