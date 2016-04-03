<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Just Remember</title>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,500&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='/static/css/ngDialog.css' />">
    <link rel="stylesheet" href="<c:url value='/static/css/ngDialog-theme-default.css' />">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
</head>
<body ng-app="JustRememberApp" class="ng-cloak">
    <div class="header">
        <div class="headerInner">
            <div class="logo">JUST REMEMBER</div>
            <div class="menu"></div>
        </div>
    </div>

    <div class="content" ng-controller="NoteController as ctrl">

        <div class="addBtn">
            <a href="#" ng-click="ctrl.openNoteDialog()">+</a>
        </div>

        <div class="note" ng-repeat="note in ctrl.notes  | orderBy : '-time'">
            <div class="noteHeader">
                <div class="noteName"><a href="#">{{note.name}}</a></div>
                <div class="noteTime">{{note.time | date: "dd.MM.yyyy в HH:mm:ss"}}</div>
            </div>
            <div class="noteOptionsBtn" ng-click="showOptionsMenu = !showOptionsMenu">
                <a href="#" class="material-icons">more_vert</a>
            </div>
            <div class="nodeOptionsMenu" ng-show="showOptionsMenu" ng-mouseleave="showOptionsMenu = false">
                <ul>
                    <li>
                        <a href="#" ng-click="ctrl.openEditNoteDialog(note.id)">
                            <span class="material-icons">mode_edit</span>Редактировать
                        </a>
                    </li>
                    <li>
                        <a href="#" ng-click="ctrl.remove(note.id)">
                            <span class="material-icons">delete</span>Удалить
                        </a>
                    </li>
                </ul>
            </div>
            <div class="noteBody">
                <p class="noteContent">{{note.content}}</p>
                <!-- <p class="noteContent">{{note.content | limitTo: 250}}{{note.content.length > 250 ? '...' : ''}}</p>
                <a class="moreBtn" href="#">Подробнее</a> -->
            </div>
        </div>
    </div>

<script type="text/ng-template" id="addDialog">

    <div class="addDialog">
        <div class="addDialogHeader">
            <span ng-if="ngDialogData.id === null">Добавление заметки</span>
            <span ng-if="ngDialogData.id != null">Редактирование заметки</span>
        </div>
        <form class="addDialogForm" ng-submit="submit()">
            <input type="hidden" ng-model="ngDialogData.id" />
            <div><input ng-model="ngDialogData.name" id="noteName" name="noteName" type="text" placeholder="Название заметки"></div>
            <div><textarea ng-model="ngDialogData.content" id="noteContent" name="noteContent"></textarea></div>
            <div>
                <button type="submit">
                    <span ng-if="ngDialogData.id === null">Добавить</span>
                    <span ng-if="ngDialogData.id != null">Сохранить</span>
                </button>
                <button type="button" ng-click="closeThisDialog(true) && reset()">Отмена</button>
            </div>
        </form>
    </div>

</script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-cookies.js"></script>
<script src="<c:url value='/static/js/directives/ngDialog.min.js' />"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/services/note_service.js' />"></script>
<script src="<c:url value='/static/js/controllers/dlg_controllers.js' />"></script>
<script src="<c:url value='/static/js/controllers/note_controller.js' />"></script>

</body>

</html>
