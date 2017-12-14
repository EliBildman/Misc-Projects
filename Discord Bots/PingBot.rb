require 'discordrb'

bot = Discordrb::Bot.new token: "MzM1NjE1MTEwMjA0ODgyOTQ0.DEs4LQ.gyHubw91CS-E-3KoCcIXrIpw8ns", client_id: "335615110204882944"

bot.message() do |e|
	e.respond("pong idiot")
end

bot.run