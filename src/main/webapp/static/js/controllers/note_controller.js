app.controller('NoteController', ['$scope', '$cookies', 'NoteService', 'ngDialog', function($scope, $cookies, NoteService, ngDialog) {
    var self = this;
    self.note = {id:null, name:'', content:'', important:1, time:0, tags:[], attachments:[]};
    self.notes = [];
    self.DialogData = {id:null, name:'', content:'', important:1, time:0, tags:[], attachments:[]};

    $cookies.put('currentUser', 1);
    self.currentUser = $cookies.get('currentUser');

    self.getAllUserNotes = function() {
        NoteService.getAllUserNotes(self.currentUser)
            .then(
                function(data) {
                    self.notes = data;
                },
                function(errResponse){
                    console.error('Error getting user notes');
                }
            );
    };

    self.openNoteDialog = function() {
        $scope.DialogData = {id:null, name:'', content:'', important:1, time:0, tags:[], attachments:[]};

        var dialog = ngDialog.open({
            template: 'addDialog',
            controller: 'AddDialogController',
            data: JSON.stringify($scope.DialogData)
        });

        dialog.closePromise.then(function (data) {
            self.getAllUserNotes();
        });
    };

    self.openEditNoteDialog = function(id) {
        for (var i = 0; i < self.notes.length; i++){
            if(self.notes[i].id === id) {
                $scope.DialogData = angular.copy(self.notes[i]);
                break;
            }
        }

        var dialog = ngDialog.open({
            template: 'addDialog',
            controller: 'AddDialogController',
            data: JSON.stringify($scope.DialogData)
        });

        dialog.closePromise.then(function (data) {
            self.getAllUserNotes();
        });
    };

    self.removeNote = function(note_id) {
        NoteService.deleteNote(self.currentUser, note_id)
            .then(
                function(data) {
                    self.getAllUserNotes();
                }
            );
    };

    self.remove = function(id) {
        self.removeNote(id);
    };

    self.getAllUserNotes();
}]);