/**
 * Created by ciazhar on 4/22/17.
 */

var app = angular.module ('bugapp',[]);

app.controller('bugController',function ($scope, $http, $window) {
    $scope.listBug = function () {
        var id = $window.sessionStorage.getItem('id');

        if (id == null) {
            $http.get('/api/bug').then(sukses, gagal);
        }
        else {
            $http.get('/api/bug/aplikasi/' + id).then(sukses, gagal);
        }

        function sukses(response) {
            $scope.daftarBug = response.data;
        }

        function gagal(response) {
            console.log('Error : ' + response);
        }

        delete sessionStorage.id;
    };
    $scope.listBug();
})