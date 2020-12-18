const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require("extract-text-webpack-plugin");

const config = {
    entry: './src/index.js',
    output: {
        filename: 'app.min.js',
        path: path.join(__dirname, 'dist'),
        publicPath: '/'
    },
    resolve:{
        extensions: ['.js']
    },
    devServer: {
        historyApiFallback: true,
    },
    module: {
        rules: [
            {
                test: /\.(js)$/,
                use: ['babel-loader'],
                exclude: /node_modules/
            },
            // {
            //     test: /.(css|less|scss|sass)$/,
            //     use: ExtractTextPlugin.extract({
            //       fallback: 'style-loader',
            //       use: ["style-loader", 'css-loader', 'postcss-loader', 'less-loader', 'sass-loader'], // This doesn't work
            //     })
            // },
            {
                test: /\.(css)$/,
                use: [
                    {
                        loader: "style-loader"
                    },
                    {
                        loader: "css-loader"
                    },
                    // {
                    //     loader: 'postcss-loader', // Run post css actions
                    //     options: {
                    //         postcssOptions: {
                    //             plugins: [
                    //                 require('precss'),
                    //                 require('autoprefixer')
                    //               ]
                            
                    //         }
                    //     }
                    // },
                    // {
                    //     loader: "sass-loader"
                    // }
                ],
                exclude: /node_modules/
            },
            {
                test: /\.(png|jpe?g|gif)$/i,
                use: [
                  {
                    loader: 'file-loader',
                  },
                ],
                exclude: /node_modules/
            },
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({ template: './public/index.html' }),
        // new ExtractTextPlugin({filename: '[name].css', allChunks: true}),
        // new ExtractTextPlugin("styles.css"),
    ],
}

module.exports = config;