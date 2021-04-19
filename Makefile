restart-docker:
	@sudo docker-compose stop
	@sudo docker-compose rm -f
	@sudo docker-compose up -d

start-dev:
	@git remote add prod https://git.heroku.com/people-prod.git
	@git remote add stage https://git.heroku.com/people-stage.git
	@sudo docker-compose up -d