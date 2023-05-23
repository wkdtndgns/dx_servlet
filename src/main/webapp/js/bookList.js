/**
 * dx_servlet
 *
 * @author shjang02 < shjang02@simplexi.com >
 * @since 2023. 05. 23.
 */

$(document).ready(function() {
    // 페이지 파라미터를 받아옴 (예시로 1부터 5까지 페이지가 있다고 가정)
    var currentPage = $('#hidPage').val();
    var totalPages = $('#hidTotalPage').val();

    var $pagination = $(".pagination");

    // 페이지 링크 생성
    for (var i = 1; i <= totalPages; i++) {

        var $pageLink = $("<li>").append($("<a>").attr("href", "#").text(i));

        // 현재 페이지에 해당하는 링크에 active 클래스 추가
        if (i == currentPage) {
            $pageLink.addClass("active");
        }

        $pagination.append($pageLink);
    }

    // 페이지 링크 클릭 이벤트 처리
    $pagination.on("click", "li", function() {
        var clickedPage = $(this).text();

        // 페이지 링크 클릭 시 해당 페이지로 이동 (예시: URL에 page 파라미터 추가)
        window.location.href = "?page=" + clickedPage + "&"+ $('#frmBookList').serialize();
    });
});