var exec = require('cordova/exec');

function OpenInBrowser() {
    console.log("OpenInBrowser.js: is created");
}

OpenInBrowser.prototype.open = function(url) {
    exec(function(result) {
        // Success callback
    }, function(result) {
        // Error callback
    }, "OpenInBrowser", "openInBrowser", [url]);
};

var browser = new OpenInBrowser();
module.exports = browser;