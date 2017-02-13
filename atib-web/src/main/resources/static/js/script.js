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
            })
        
            .when('/contribute', {
            	templateUrl : 'pages/contribute.html',
            	controller  : 'contributeController'
            });
    });

    // create the controller and inject Angular's $scope
    atibApp.controller('mainController', function($scope) {
        // create a message to display in our view
        $scope.image = [{
        	src: 'img/trump-pepe-frog2.png',
        }];
    });

    atibApp.controller('aboutController', function($scope) {
        $scope.message = 'The purpose of this project is to build a web application that gathers information and data relating to the United States 45th President Donald Trump. This is a strictly data oriented project and is not a political statement. This project is to remain as un-biased as possible in its purpose of displaying data. The referenced data can include, but is not limited to, news articles, Twitter statistics and tweets, Facebook posts, and any other information that could be relevant. This project will attempt to accumulate all this data in an automated fashion with limited input from the creators.';
    });

    atibApp.controller('contactController', function($scope) {
        $scope.message = '';
    });
    
    atibApp.controller('contributeController', function($scope) {
        $scope.message = 'Feel like contributing to A.T.I.B ?';
    });
