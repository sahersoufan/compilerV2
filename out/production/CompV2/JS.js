<script>
changes = [];
renders = [];
        document.getElementById("myTestInput").value = forthyear.myTest;
        var myTestInputChanges = function (event) {
            forthyear.myTest = document.getElementById("myTestInput").value;
        };
        document.getElementById("myTestInput").addEventListener("input", function(event) {
            changes.push(myTestInputChanges);
        });
        changes.push(myTestInputChanges);
        var myTestDivChanges4Must = function (event) {
            var defaultText = "My Text is: {{myTest}}";
            document.getElementById("myTestDiv").innerHTML = defaultText.replace("{{myTest}}", forthyear.myTest);
        };
 renders.push(myTestDivChanges4Must);
        function render() {
            setInterval(() => {
                console.log("render")
                // for (change in changes) {
                for (var i = 0; i < changes.length; i++) {
                    // console.log(changes[i]);
                    changes[i]();
                }
                changes = [];
                for (var i = 0; i < renders.length; i++) {
                    renders[i]();
                    }            }, 1000);
        }
        render();
</script>
