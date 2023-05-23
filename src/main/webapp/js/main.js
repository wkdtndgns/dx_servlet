/**
 * dx_servlet
 *
 * @author shjang02 < shjang02@simplexi.com >
 * @since 2023. 05. 23.
 */
$(document).ready(function () {
    var menuData = [
        {text: "Home", href: "/"},
        {text: "도서 등록", href: "/bookRegister"},
        {text: "도서 검색", href: "/bookList"},
        {text: "도서 대출", href: "/rentList"},
        {text: "도서 반납", href: "/returnList"},
        {text: "도서 대출 이력", href: "/rentListHistory"},
        {text: "도서 리뷰", href: "/reviewList"},
        {text: "도서 추천", href: "/recommend"},
    ];

    var $menu = $("#menu");

    // 메뉴 데이터를 기반으로 메뉴 아이템을 동적으로 생성하고 링크 및 active 클래스를 설정
    for (var i = 0; i < menuData.length; i++) {
        var menuItem = menuData[i];
        var $menuItem = $("<li>").append($("<a>").text(menuItem.text).attr("href", menuItem.href));

        // 현재 URL 경로와 링크 경로를 비교하여 active 클래스 추가
        if (window.location.pathname === menuItem.href) {
            $menuItem.addClass("active");
        }

        $menu.append($menuItem);
    }
});