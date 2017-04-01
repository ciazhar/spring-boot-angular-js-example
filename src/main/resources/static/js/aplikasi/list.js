/**
 * Created by ciazhar on 3/31/17.
 */

var app = angular.module ('aplikasiapp',[]);

app.controller('aplikasiController',function ($scope, $http, $window) {
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

    var urlRedirect = "http://localhost:8080/aplikasi/form";
    $scope.redirect = function (aplikasi) {
        $window.location.href = urlRedirect;
        $window.sessionStorage.setItem('id',aplikasi.id_aplikasi);
    }

})

app.controller('formController',function ($scope, $http, $window) {
    var urlListAplikasi = "http://localhost:8080/aplikasi/list";
    var idnya = $window.sessionStorage.getItem('id');

    $scope.formAplikasi = function () {
        $http.get('/api/aplikasi/'+idnya).then(sukses, gagal);
        function sukses(response){
            $scope.findedAplikasi = response.data;
        }
        function gagal(response){
            console.log('Error'+response);
        };
        delete sessionStorage.id;/// delete id agar tidak terjadi redundan
    };
    $scope.formAplikasi();

    $scope.simpanAplikasi = function () {
        ///Kondisi ini untuk mengantisipasi tidak terdetensinya inputan sehingga tidak menjadi json
        $scope.aplikasi.id_aplikasi = $scope.findedAplikasi.id_aplikasi;
        if ($scope.aplikasi.nama_aplikasi != $scope.findedAplikasi.nama_aplikasi){
            $scope.aplikasi.nama_aplikasi = $scope.findedAplikasi.nama_aplikasi;
        }
        if ($scope.aplikasi.status_rilis_aplikasi != $scope.findedAplikasi.status_rilis_aplikasi){
            $scope.aplikasi.status_rilis_aplikasi = $scope.findedAplikasi.status_rilis_aplikasi;
        }

        $http.post('/api/aplikasi', $scope.aplikasi).then(sukses,gagal);
        function sukses(response) {
            $window.location.href = urlListAplikasi;
        };
        function gagal(response) {
            console.log('Error'+response);
        };
    };
})