		$(document).ready(function() {
			$("img").click(function() {
				if (!$(".overlay").hasClass('active')) {
					$(".overlay").fadeIn().toggleClass('active');
				} else {
					$(".overlay").fadeOut().removeClass('active');
				}
			});
		});