# Use an official Nginx runtime as the base image
FROM nginx:latest

# Copy your web application files into the container's default HTML directory
COPY ./path/to/your/web/app /usr/share/nginx/html

# Expose port 80 for incoming web traffic
EXPOSE 80

# Start the Nginx web server when the container starts
CMD ["nginx", "-g", "daemon off;"]
