// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/Reduce

function sym() {
    var args = [];
    for(var i = 0, numArgs = arguments.length; i< numArgs; i++) {
        args.push(arguments[i]);
    }

    return args.reduce(function (mainArray, currentArray) {

        // Remove duplicates in currentArray
        currentArray = currentArray.reduce(function(main, curr) {
            if (main.indexOf(curr) === -1) {
                main.push(curr);
            }
            return main;
        }, []);

        // Check Symmetric Difference between mainArray and currentArray
        for (var i = 0; i < currentArray.length; i++) {
            if (mainArray.indexOf(currentArray[i]) === -1) {
                mainArray.push(currentArray[i]);
            }
            else {
                mainArray.splice(mainArray.indexOf(currentArray[i]), 1);
            }
        }

        return mainArray;
    }, []).sort();
}

console.log(sym([3, 3, 3, 2, 5], [2, 1, 5, 7], [3, 4, 6, 6], [1, 2, 3], [5, 3, 9, 8], [1]));
// Return [1, 2, 4, 5, 6, 7, 8, 9]
