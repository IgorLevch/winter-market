
angular.module('app', []).controller('indexController', function($scope,$http){
    console.log(123);

    $scope.loadProducts =  function ()  {
    $http.get('http://localhost:8189/winter/api/v1/products').then(function(response){
       // console.log(response.data);
       $scope.productsList = response.data;

    });
    }
    
    $scope.showProductInfo  =   function(productId){
        $http.get('http://localhost:8189/winter/api/v1/products/' + productId).then(function(response){
           alert(response.data.title);  
    });

    }

    $scope.deleteProductById  =   function(productId){
        $http.delete('http://localhost:8189/winter/api/v1/products/' + productId).then(function(response){
            
            $scope.loadProducts();             

    });

    }


    $scope.addToCart = function(productId){

        $http.get('http://localhost:8189/winter/api/v1/cart/add/'+productId).then(function(response){
        $scope.loadCart();

        });
        }

        
        $scope.deleteFromCart = function(){

            $http.delete('http://localhost:8189/winter/api/v1/cart/delete').then(function(response){

            $scope.loadCart();
        });
            }


            $scope.deleteItem = function(productId){

                $http.delete('http://localhost:8189/winter/api/v1/cart/delete/'+productId).then(function(response){
        
                $scope.loadCart();
                     });
                }     




    $scope.loadCart = function(){

        $http.get('http://localhost:8189/winter/api/v1/cart').then(function(response){

        $scope.cart = response.data;

        });
        }





    $scope.loadProducts();
    $scope.loadCart();

    // const contextPath = 'http://localhost:8080/api/v1/products';

    // console.log(123);

    // $scope.loadProducts = function(pageIndex=1){

    // $http ({
    //     method:'GET',
    //     url: contextPath,
    //     params: {
    //         title_part: $scope.filter ? $scope.filter.title_part: null,
    //         min_mark: $scope.filter ? $scope.filter.min_mark: null,
    //         max_mark: $scope.filter ? $scope.filter.max_mark: null,
    //         p : page
    //     }
    // })  .then(function (response) {
    //         $scope.ProductsList = response.data.content;
    // });

    // };


    // $scope.deleteProduct = function(productId){
    //     $http.delete(contextPath + productId)
    //     .then(function (response){
    //         $scope.loadProducts();
    //         console.log(response.data)

    //     });

    // }


    //  $scope.findProduct = function(productId){
    //     $http.get(contextPath+productId)
    //         .then(function (response){
    //         $scope.ProductsList = response.data
    //         });

    //  }

    //  $scope.findProductByTitle = function(productTitle){
    //     $http.get(contextPath+productTitle)
    //         .then(function(response){
    //         $scope.productId = response.data

    //         });
    //  }

    // $scope.createProductJson = function(){
    //     console.log($scope.newProductJson);
    //     $http.post(contextPath, $scope.newProductJson)
    //     .then(function(response){
    //     $scope.loadProducts();
    //     });
    // }


    // $scope.loadProducts();


});