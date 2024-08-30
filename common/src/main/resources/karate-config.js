function fn() {
    var config = {
        baseUrl: karate.properties['karate.baseUrl'] || 'http://localhost:8080'
    };
    return config;
}