/**
 * Created by ciazhar on 3/31/17.
 */

var app = angular.module ('aplikasiapp',[]);

app.controller('aplikasiController',function ($scope, $http) {
    $scope.daftarAplikasi = {};

    $scope.listAplikasi = function(){
        $http.get('/api/aplikasi').then(sukses,gagal);
        function sukses(response) {
            $scope.daftarAplikasi = response.data;
        }
        function gagal(response) {
            console.log('Error : '+response);
        }
    };
    $scope.listAplikasi();

    $scope.hapusAplikasi = function(aplikasi){
        $http.delete('/api/aplikasi/'+aplikasi.id_aplikasi).then(sukses, gagal);
        function sukses(response){
            $scope.listAplikasi();
        }
        function gagal(response){
            console.log('Error'+response);
        };
    };

    // $scope.simpanAplikasi = function () {
    //     $http.post('/api/aplikasi', $scope.aplikasi).then(sukses,gagal);
    //     function sukses(response) {
    //         $scope.
    //     };
    //     function gagal(response) {
    //
    //     };
    // };
})