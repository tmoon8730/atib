// script.js

    // create the module
     // also include ngRoute for all our routing needs
    var atibApp = angular.module('atibApp', ['ngRoute']);

    // configure our routes
    atibApp.config(function($routeProvider) {
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'pages/home.html',
                controller  : 'mainController'
            })

            // route for the about page
            .when('/about', {
                templateUrl : 'pages/about.html',
                controller  : 'aboutController'
            })

            // route for the contact page
            .when('/contact', {
                templateUrl : 'pages/contact.html',
                controller  : 'contactController'
            });
    });

    // create the controller and inject Angular's $scope
    atibApp.controller('mainController', function($scope) {
        // create a message to display in our view
        $scope.message = 'Automated Trump Information Bot.';
    });

    atibApp.controller('aboutController', function($scope) {
        $scope.message = 'About.';
    });

    atibApp.controller('contactController', function($scope) {
        $scope.message = 'Contact us.';
    });
