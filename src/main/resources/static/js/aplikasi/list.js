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
        $http.delete('/api/aplikasi/'+aplikasi.id).then(sukses, gagal);
        function sukses(response){
            $scope.listAplikasi();
        }
        function gagal(response){
            console.log('Error'+response);
        };
    };

    var urlRedirect = "http://localhost:8080/aplikasi/form";
    $scope.editAplikasi = function (aplikasi) {
        $window.location.href = urlRedirect;
        $window.sessionStorage.setItem('id',aplikasi.id);
    }

    var urlDetilAplikasi = "http://localhost:8080/versi/list";
    $scope.detilAplikasi = function (aplikasi) {
        $window.location.href = urlDetilAplikasi;
        $window.sessionStorage.setItem('id',aplikasi.id);
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
        ///Kondisi ini untuk mengantisipasi tidak terdeteksinya value di field sehingga tidak menjadi json utuh
        $scope.aplikasi.id = $scope.findedAplikasi.id;
        if ($scope.aplikasi.nama == null){
            $scope.aplikasi.nama = $scope.findedAplikasi.nama;
        }
        if ($scope.aplikasi.statusRilis == null){
            $scope.aplikasi.statusRilis = $scope.findedAplikasi.statusRilis;
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