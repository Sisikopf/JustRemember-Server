app.controller('AddDialogController', ['$scope', '$cookies', 'NoteService', function($scope, $cookies, NoteService) {
    var self = this;
    self.note = {id:null, name:'', content:'', important:1, time:0, tags:[], attachments:[]};
    self.currentUser = $cookies.get('currentUser');

    $scope.submit = function() {
        self.note = $scope.ngDialogData;
        self.note.time = new Date().getTime();

        if ($scope.ngDialogData.id === null) {
            NoteService.createNote(self.currentUser, self.note)
                .then(
                    function (data) {
                        $scope.reset();
                        $scope.$parent.closeThisDialog(true);
                    }
                );
        } else {
            NoteService.updateNote(self.currentUser, self.note, self.note.id).then(
                function (data) {
                    $scope.reset();
                    $scope.$parent.closeThisDialog(true);
                }
            );
        }
    };

    $scope.reset = function() {
        $scope.ngDialogData.name = '';
        $scope.ngDialogData.content = '';
        $scope.ngDialogData.id = null;
    };
}]);