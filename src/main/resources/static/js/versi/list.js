/**
 * Created by ciazhar on 4/1/17.
 */

var app = angular.module ('versiapp',[]);

app.controller('versiController',function ($scope, $http, $window) {
    $scope.daftarVersi = {};

    $scope.listVersi = function(){
        var id = $window.sessionStorage.getItem('id');

        if(id==null){
            $http.get('/api/versi').then(sukses,gagal);
        }
        else {
            $http.get('/api/versi/aplikasi/'+id).then(sukses,gagal);
        }

        function sukses(response) {
            $scope.daftarVersi = response.data;
        }
        function gagal(response) {
            console.log('Error : '+response);
        }
        delete sessionStorage.id;
    };
    $scope.listVersi();

    // $scope.hapusVersi = function(versi){
    //     $http.delete('/api/versi/'+versi.id_versi).then(sukses, gagal);
    //     function sukses(response){
    //         $scope.listVersi();
    //     }
    //     function gagal(response){
    //         console.log('Error'+response);
    //     };
    // };
    //
    var urlRedirect = "http://localhost:8080/versi/form";
    $scope.editVersi = function (versi) {
        $window.location.href = urlRedirect;
        $window.sessionStorage.setItem('id_versi',versi.id);
    }

    var urlListBug = "http://localhost:8080/bug/list";
    $scope.listBug = function (versi) {
        $window.location.href = urlListBug;
        $window.sessionStorage.setItem('id',versi.id);
    }
})

app.controller('formController',function ($scope, $http, $window) {
    var urlListVersi = "http://localhost:8080/versi/list";
    var idnya = $window.sessionStorage.getItem('id');

    $scope.formVersi = function () {
        $http.get('/api/versi/?id='+idnya).then(sukses, gagal);
        function sukses(response){
            $scope.findedVersi = response.data;
        }
        function gagal(response){
            console.log('Error'+response);
        };
        delete sessionStorage.id;/// delete id agar tidak terjadi redundan
    };
    $scope.formVersi();

    $scope.simpanVersi = function () {
        ///Kondisi ini untuk mengantisipasi tidak terdeteksinya value di field sehingga tidak menjadi json utuh
        $scope.versi.id = $scope.findedVersi.id;
        $scope.versi.aplikasi = $scope.findedVersi.aplikasi;
        if ($scope.versi.versi == null){
            $scope.versi.versi = $scope.findedVersi.versi;
        }
        if ($scope.versi.tanggalDibuat == null){
            $scope.versi.tanggalDibuat = $scope.findedVersi.tanggalDibuat;
        }
        if ($scope.versi.tanggalRilis == null){
            $scope.versi.tanggalRilis = $scope.findedVersi.tanggalRilis;
        }

        $http.post('/api/versi', $scope.versi).then(sukses,gagal);
        function sukses(response) {
            $window.location.href = urlListVersi;
        };
        function gagal(response) {
            console.log('Error'+response);
        };
    };
})