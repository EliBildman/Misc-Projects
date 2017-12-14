require 'watir'
require 'discordrb'

bot = Discordrb::Bot.new token: "MzM1NjE1MTEwMjA0ODgyOTQ0.DEs4LQ.gyHubw91CS-E-3KoCcIXrIpw8ns", client_id: "335615110204882944"

def jpeg(url)
	b = Watir::Browser.new :firefox
	b.goto "http://needsmorejpeg.com/"
	b.link(:text, "From URL").wait_until_present.click
	b.text_field(:name, "image").set(url)
	b.button(:value, "Submit").click
	b.images[0]
end

bot.message() do |e|
	e.respond(e.attach_file)
end

bot.run
