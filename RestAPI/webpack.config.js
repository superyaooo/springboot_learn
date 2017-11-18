var path = require('path');
var webpack = require('webpack');

module.exports = {
    entry: './src/main/js/app.js',
    devtool: 'sourcemaps',
    cache: true,
    debug: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            }
        ]
    },
    plugins: [
    		new webpack.optimize.UglifyJsPlugin({
    			compress: {
    				warnings: false,
    			},
    			output: {
    				comments: false,
    			},
    		}),
    ]
};